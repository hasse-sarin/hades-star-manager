(ns hades-star-manager.players.player
  (:require [re-frame.core :as re-frame]
            [re-com.core :as re-com]
            [reagent.core :as reagent]
            [hades-star-manager.events :as events]
            [hades-star-manager.modules.mining :as mining]
            [hades-star-manager.modules.shield :as shield]
            [hades-star-manager.modules.support :as support]
            [hades-star-manager.modules.weapon :as weapon]
            [hades-star-manager.subs :as subs]))

(defn player-info []
  [re-com/v-box
   :gap "1em"
   :children [[re-com/title
               :label "Player info"
               :level :level3]
              [re-com/v-box
               :children [[re-com/h-box
                           :gap "0.2em"
                           :children [[:span.field-label "Player name"]
                                      [re-com/info-button
                                       :info "info"]]]
                           [re-com/input-text
                           :model (re-frame/subscribe [::subs/player-name])
                           :placeholder "Insert your name"
                           :on-change #((re-frame/dispatch [::events/set-player-name %]))]]]
              [re-com/v-box
               :children [[re-com/h-box
                           :gap "0.2em"
                           :children [[:span.field-label "Battleship"]
                                       [re-com/info-button
                                       :info "info"]]]
                          [re-com/single-dropdown
                           :choices (re-frame/subscribe [::subs/battleships])
                           :model (re-frame/subscribe [::subs/player-battleship])
                           :placeholder "Select your battleship"
                           :on-change #((re-frame/dispatch [::events/set-player-battleship %]))
                           :width "250px"]]]
              [re-com/v-box
               :children [[re-com/h-box
                           :gap "0.2em"
                           :children [[:span.field-label "Supportship"]
                                       [re-com/info-button
                                       :info "info"]]]
                          [re-com/single-dropdown
                           :choices (re-frame/subscribe [::subs/supportships])
                           :model (re-frame/subscribe [::subs/player-supportship])
                           :placeholder "Select your supportship"
                           :on-change #((re-frame/dispatch [::events/set-player-supportship %]))
                           :width "250px"]]]]])

(defn battleship-loadout []
  [re-com/v-box
   :gap "1em"
   :children [[re-com/title
               :label "Battleship info"
               :level :level3]
              [weapon/weapon-module-dropdown {:title "Weapon" :info "Info" :placeholder "Select your weapon"}]
              [shield/shield-module-dropdown {:title "Shield" :info "Info" :placeholder "Select your shield"}]
              [support/support-module-dropdown {:title "Support" :info "Info" :placeholder "Select your support module"}]]])

(defn supportship-loadout []
  [re-com/v-box
   :gap "1em"
   :children [[re-com/title
               :label "Supportship info"
               :level :level3]
              [mining/mining-module-dropdown {:title "Mining" :info "Info" :placeholder "Select your mining module"}]
              [support/support-module-dropdown {:title "Support" :info "Info" :placeholder "Select your support module"}]]])

(defn add-player-component []
  [re-com/h-box
   :gap "1em"
   :justify :between
   :class "add-player-component"
   :children [[player-info]
              [battleship-loadout]
              [supportship-loadout]
              [re-com/button
               :label "Save"
               :tooltip "Save selected options"
               :style {:color "#fff" :background-color "#d80000"}
               :on-click #((re-frame/dispatch [::events/save-player]))]]])
