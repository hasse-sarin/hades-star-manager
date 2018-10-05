(ns hades-star-manager.db)

(def default-db
  {:name "Hades' Star Manager"
   :white-star-sizes [{:id 10 :label "10 vs 10"}
                      {:id 15 :label "15 vs 15"}
                      {:id 20 :label "20 vs 20"}]

   :corporation {:name "" :match-history []}
   :match {:score nil :home-team nil :away-team nil}
   :corporation-roster [{:name "Test user"
                         :battleship {:id 5 :label "Battleship level 5" :loadout {:weapon {:id 1 :label "Battery"} :shield {:id 2 :label "Passive shields"} :support [{:id 2 :label "Barrier"}{:id 3 :label "EMP"}]}}
                         :supportship {:id 15 :label "Miner level 5" :group "Miner" :loadout {:mining [{:id 1 :label "Mining unity"} {:id 2 :label "Remote mining"}] :support {:id 1 :label "Teleport"}}}}]
   :player {:name "" :battleship nil :supportship nil}

   :battleship {:weapon nil :shield nil :support []}
   :miner {:mining [] :support nil}
   :transport {:trade [] :support nil}

   ;; PH
   :battleships [{:id 1 :label "Battleship level 1" :loadout {:weapon nil :shield nil :support []}}
                 {:id 2 :label "Battleship level 2" :loadout {:weapon nil :shield nil :support []}}
                 {:id 3 :label "Battleship level 3" :loadout {:weapon nil :shield nil :support []}}
                 {:id 4 :label "Battleship level 4" :loadout {:weapon nil :shield nil :support []}}
                 {:id 5 :label "Battleship level 5" :loadout {:weapon nil :shield nil :support []}}]

   ;; PH
   :supportships [{:id 11 :label "Miner level 1" :group "Miner" :loadout {:mining [] :support nil}}
                  {:id 12 :label "Miner level 2" :group "Miner" :loadout {:mining [] :support nil}}
                  {:id 13 :label "Miner level 3" :group "Miner" :loadout {:mining [] :support nil}}
                  {:id 14 :label "Miner level 4" :group "Miner" :loadout {:mining [] :support nil}}
                  {:id 15 :label "Miner level 5" :group "Miner" :loadout {:mining [] :support nil}}
                  {:id 21 :label "Transport level 1" :group "Transport" :loadout {:trade [] :support nil}}
                  {:id 22 :label "Transport level 2" :group "Transport" :loadout {:trade [] :support nil}}
                  {:id 23 :label "Transport level 3" :group "Transport" :loadout {:trade [] :support nil}}
                  {:id 24 :label "Transport level 4" :group "Transport" :loadout {:trade [] :support nil}}
                  {:id 25 :label "Transport level 5" :group "Transport" :loadout {:trade [] :support nil}}]

   :modules {:weapon  [{:id 1 :label "Battery"}
                       {:id 2 :label "Mass battery"}
                       {:id 3 :label "Laser"}]
             :shield  [{:id 1 :label "Alpha shield"}
                       {:id 2 :label "Passive shields"}
                       {:id 3 :label "Omega shields"}]
             :support [{:id 1 :label "Teleport"}
                       {:id 2 :label "Barrier"}
                       {:id 3 :label "EMP"}]
             :mining  [{:id 1 :label "Mining unity"}
                       {:id 2 :label "Remote mining"}
                       {:id 3 :label "Mining boost"}]}

   :feedback {:id 0
              :items []}
  })
