(ns hades-star-manager.css
  (:require [garden.def :refer [defstyles]]))

(defstyles screen
  [:body {:height "100%"}]
  [:.level1 {:color "darkred"}]
  
  [:#app {
    :height "100%"}]
  [:.container {
    :background-color "#eee"
    :padding "1em"}]
    
  [:.player-manager {
    :background-color "#ddd"
    :border "1px solid #bbb"
    :padding "0.8em"
    :box-shadow "0.3em 0.3em 0.5em #0000002f"}])
