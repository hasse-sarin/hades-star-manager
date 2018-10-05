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

(re-frame/reg-event-db
 ::set-player-name
 (fn-traced [db [_ name]]
   (assoc-in db [:player :name] name)))

(re-frame/reg-event-db
 ::set-player-battleship
 (fn-traced [db [_ battleship]]
   (assoc-in db [:player :battleship] battleship)))

(re-frame/reg-event-db
 ::set-player-supportship
 (fn-traced [db [_ supportship]]
   (assoc-in db [:player :supportship] supportship)))

(re-frame/reg-event-db
 ::add-feedback-item
 (fn-traced [db [_ type message]]
  (update-in db [:feedback :id] inc) ;; TODO: coeffect? effect? Learn more how to deal.
  (update-in db [:feedback :items] conj {:id (get-in db [:feedback :id]) :type type :message message})))

(re-frame/reg-event-db
 ::save-player
 (fn-traced [db [_ _]]
   ;; TODO: Create a check to make sure that pleyer information has been filled or show feedback
   ;; TODO: Add check that White star size has been selected or show feedback
   (if (< (count (:corporation-roster db)) (:selected-white-star-size db))
    (update-in db [:corporation-roster] conj {:name (get-in db [:player :name])
                                              :battleship (first (filter #(= (get-in db [:player :battleship]) (:id %)) (:battleships db)))
                                              :supportship (first (filter #(= (get-in db [:player :supportship]) (:id %)) (:supportships db)))})
    nil ;; TODO: Create user feedback, too many players in roster
      )))
