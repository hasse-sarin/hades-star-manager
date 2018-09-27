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
 ::battleships
 (fn [db]
   (:battleships db)))

(re-frame/reg-sub
 ::supportships
 (fn [db]
   (:supportships db)))  

(re-frame/reg-sub
 ::active-panel
 (fn [db _]
   (:active-panel db)))
