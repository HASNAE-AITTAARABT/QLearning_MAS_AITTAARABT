# Q-learning implemetation using MAS
![image](https://github.com/HASNAE-AITTAARABT/QLearning_MAS_AITTAARABT/assets/100070887/986435bc-2b9c-4c7d-9e05-ce090f197f5c)


- Q-Learning est une technique d'apprentissage par renforcement qui vise à apprendre une politique qui dit à un agent quelle action prendre sous certaines circonstances. 
Il ne nécessite pas de modèle de l'environnement (c'est-à-dire que l'agent n'a pas besoin de connaître l'ensemble complet des états et des transitions),
ce qui le rend utile pour les problèmes où seul un retour d'information de récompense est donné.

- L'idée fondamentale du Q-Learning est que nous avons une fonction, Q, qui peut nous dire quelle sera la récompense à long terme pour une action donnée dans un état donné.
  Cette fonction est apprise en itérant et en mettant à jour les valeurs Q en fonction de l'équation de Bellman,qui donne une relation entre la valeur Q d'un état et la valeur Q des états suivants.

- En pratique, l'agent commence par initialiser la table Q avec des valeurs arbitraires, puis il interagit avec l'environnement et met à jour les valeurs de la table Q en fonction de la récompense qu'il reçoit pour ses actions.
-  Au fil du temps, cette table Q converge vers les véritables valeurs Q, et l'agent peut utiliser cette table pour sélectionner les actions qui maximisent la récompense à long terme.
