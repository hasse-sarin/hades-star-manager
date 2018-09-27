(ns hades-star-manager.players.player
  (:require [re-frame.core :as re-frame]
    [re-com.core :as re-com]
    [reagent.core :as reagent]
    [hades-star-manager.events :as events]
    [hades-star-manager.subs :as subs]))

(defn add-player []
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
                           :model (reagent/atom "nil")
                           :on-change #()]]]
              [re-com/v-box
               :children [[re-com/h-box
                           :gap "0.2em"
                           :children [[:span.field-label "Battleship"]
                                       [re-com/info-button
                                       :info "info"]]]
                          [re-com/single-dropdown
                           :choices (re-frame/subscribe [::subs/battleships])
                           :model (re-frame/subscribe [::subs/selected-white-star-size])
                           :placeholder "Select your battleship"
                           :on-change #()
                           :width "250px"]]]
              [re-com/v-box
               :children [[re-com/h-box
                           :gap "0.2em"
                           :children [[:span.field-label "Supportship"]
                                       [re-com/info-button
                                       :info "info"]]]
                          [re-com/single-dropdown
                           :choices (re-frame/subscribe [::subs/supportships])
                           :model (re-frame/subscribe [::subs/selected-white-star-size])
                           :placeholder "Select your supportship"
                           :on-change #()
                           :width "250px"]]]]])
