(ns hades-star-manager.players.roster
  (:require [re-frame.core :as re-frame]
            [re-frame-datatable.core :as dt]
            [re-com.core :as re-com]
            [reagent.core :as reagent]
            [hades-star-manager.events :as events]
            [hades-star-manager.subs :as subs]))

(defn roster-container []
  [dt/datatable
   :roster-table
   [::subs/player-roster]
   [{::dt/column-key   [:name]
     ::dt/column-label "Name"}
    {::dt/column-key   [:battleship]
     ::dt/column-label "Battleship"
     ::dt/sorting      {::dt/enabled? true}
     ::dt/render-fn    (fn [val]
                         [:span (str (:label val))])}
    {::dt/column-key   [:supportship]
     ::dt/column-label "Supportship"
     ::dt/sorting      {::dt/enabled? true}
     ::dt/render-fn    (fn [val]
                         [:span (str (:label val))])}]
   {::dt/pagination    {::dt/enabled? true
                        ::dt/per-page 5}
    ::dt/table-classes ["ui" "table" "celled"]}])
