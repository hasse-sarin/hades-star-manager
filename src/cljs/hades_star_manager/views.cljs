(ns hades-star-manager.views
  (:require [re-frame.core :as re-frame]
            [re-com.core :as re-com]
            [reagent.core :as reagent]
            [hades-star-manager.events :as events]
            [hades-star-manager.subs :as subs]
            [hades-star-manager.modules.module-selector :as module-selector]
            [hades-star-manager.players.player :as player]))

;; home
(defn home-title []
  (let [name (re-frame/subscribe [::subs/name])]
    [re-com/title
     :label (str "Welcome to " @name ".")
     :level :level1]))

;; TODO: Figure out where this goes
(defn white-star-selector []
  [re-com/single-dropdown
   :choices (re-frame/subscribe [::subs/white-star-sizes])
   :model (re-frame/subscribe [::subs/selected-white-star-size])
   :placeholder "Select a white star size"
   :on-change #(re-frame/dispatch [::events/set-active-white-star-size %])
   :width "250px"])

;; TODO: Move to crafts?
(defn battleship-loadout []
  [re-com/v-box
   :gap "1em"
   :children [[re-com/title
               :label "Battleship info"
               :level :level3]
              [module-selector/module-view {:title "Weapon" :info "Info" :placeholder "Select your weapon"}]
              [module-selector/module-view {:title "Shield" :info "Info" :placeholder "Select your shield"}]
              [module-selector/module-view {:title "Support" :info "Info" :placeholder "Select your support module"}]]])

;; TODO: Move to crafts?
(defn supportship-loadout []
  [re-com/v-box
   :gap "1em"
   :children [[re-com/title
               :label "Supportship info"
               :level :level3]
              [module-selector/module-view {:title "Mining" :info "Info" :placeholder "Select your mining module"}]
              [module-selector/module-view {:title "Support" :info "Info" :placeholder "Select your support module"}]]])              

;; TODO: Move to players?
(defn player-manager []
  [re-com/h-box
   :gap "1em"
   :justify :between
   :class "player-manager"
   :children [[player/add-player]
              [battleship-loadout]
              [supportship-loadout]
              [re-com/button 
               :label "Save"
               :tooltip "Save selected options"
               :style {:color "#fff" :background-color "#d80000"}]]])

(defn link-to-about-page []
  [re-com/hyperlink-href
   :label "go to About Page"
   :href "#/about"])

(defn home-panel []
  [re-com/v-box
   :gap "1em"
   :width "1024px"
   :height "100%"
   :class "container"
   :children [[home-title]
              [re-com/title
               :label "Please select which White star match type you want to plan for"
               :level :level3]
              [white-star-selector]
              [player-manager]
              [re-com/md-icon-button
               :md-icon-name "zmdi-plus"
               :emphasise? true
               :tooltip "Add new player"
               :on-click #()]
              [link-to-about-page]]])

;; about
(defn about-title []
  [re-com/title
   :label "This is the About Page."
   :level :level1])

(defn link-to-home-page []
  [re-com/hyperlink-href
   :label "go to Home Page"
   :href "#/"])

(defn about-panel []
  [re-com/v-box
   :gap "1em"
   :children [[about-title]
              [link-to-home-page]]])

;; main
(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    :about-panel [about-panel]
    [:div]))

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [re-com/v-box
     :height "100%"
     :align :center
     :children [[panels @active-panel]]]))
