(ns hades-star-manager.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
 ::white-star-sizes
 (fn [db]
   (:white-star-sizes db)))

(re-frame/reg-sub
 ::selected-white-star-size
 (fn [db]
   (:selected-white-star-size db)))

(re-frame/reg-sub
 ::player-name
 (fn [db]
   (get-in db [:player :name])))

(re-frame/reg-sub
 ::player-battleship
 (fn [db]
   (get-in db [:player :battleship])))

(re-frame/reg-sub
 ::player-supportship
 (fn [db]
   (get-in db [:player :supportship])))

(re-frame/reg-sub
 ::player-roster
 (fn [db]
   (:corporation-roster db)))

(re-frame/reg-sub
 ::battleships
 (fn [db]
   (:battleships db)))

(re-frame/reg-sub
 ::supportships
 (fn [db]
   (:supportships db)))

(re-frame/reg-sub
 ::mining-modules
 (fn [db type]
   (get-in db [:modules :mining])))

(re-frame/reg-sub
  ::shield-modules
  (fn [db type]
    (get-in db [:modules :shield])))

(re-frame/reg-sub
 ::support-modules
 (fn [db type]
   (get-in db [:modules :support])))

(re-frame/reg-sub
 ::weapon-modules
 (fn [db type]
   (get-in db [:modules :weapon])))

(re-frame/reg-sub
 ::active-panel
 (fn [db _]
   (:active-panel db)))
