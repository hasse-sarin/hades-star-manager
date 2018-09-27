(ns hades-star-manager.events
  (:require
   [re-frame.core :as re-frame]
   [hades-star-manager.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced defn-traced]]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn-traced [_ _]
   db/default-db))

(re-frame/reg-event-db
 ::set-active-panel
 (fn-traced [db [_ active-panel]]
   (assoc db :active-panel active-panel)))

(re-frame/reg-event-db
 ::set-active-white-star-size
 (fn-traced [db [_ white-star-size]]
   (assoc db :selected-white-star-size white-star-size)))