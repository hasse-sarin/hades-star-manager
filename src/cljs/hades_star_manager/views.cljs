(ns hades-star-manager.views
  (:require [re-frame.core :as re-frame]
            [re-com.core :as re-com]
            [reagent.core :as reagent]
            [hades-star-manager.events :as events]
            [hades-star-manager.subs :as subs]
            [hades-star-manager.players.player :as player]
            [hades-star-manager.players.roster :as roster]))

;; home
(defn home-title []
  (let [name (re-frame/subscribe [::subs/name])]
    [re-com/title
     :label (str "Welcome to " @name ".")
     :level :level1]))

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
              [roster/white-star-selector]
              [roster/roster-container]     ;; TODO: Only show this after White star size has been selected
              [player/add-player-component] ;; TODO: Only show this after White star size has been selected
              [re-com/md-icon-button
               :md-icon-name "zmdi-plus"
               :emphasise? true
               :tooltip "Add new player"
               :on-click #(re-frame/dispatch [::events/add-feedback-item :error "Roster full"])] ;; Is this button still useful?
              [link-to-about-page]]])

;; about
(defn about-panel []
  [re-com/v-box
   :gap "1em"
   :children [[re-com/title
               :label "This is the About Page."
               :level :level1]
              [re-com/hyperlink-href
               :label "go to Home Page"
               :href "#/"]]])

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
