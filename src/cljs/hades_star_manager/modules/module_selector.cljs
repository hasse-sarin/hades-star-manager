(ns hades-star-manager.modules.module-selector
  (:require [re-frame.core :as re-frame]
    [re-com.core :as re-com]
    [reagent.core :as reagent]
    [hades-star-manager.events :as events]
    [hades-star-manager.subs :as subs]))

(defn module-view [{:keys [title info placeholder]}]
  [re-com/v-box
   :children [[re-com/h-box
               :gap "0.2em"
               :children [[:span.field-label title]
                          [re-com/info-button
                           :info info]]]
              [re-com/single-dropdown
               :choices (re-frame/subscribe [::subs/white-star-sizes]) ;; PH
               :model (re-frame/subscribe [::subs/selected-white-star-size]) ;; PH
               :placeholder placeholder
               :on-change #()
               :width "250px"]]])
