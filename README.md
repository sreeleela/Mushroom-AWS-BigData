# Mushroom-AWS-BigData
Mushroom Dataset<br>
Source: http://archive.ics.uci.edu/ml/datasets/Mushroom<br>
The Mushroom data set includes descriptions of hypothetical samples corresponding to species of gilled mushrooms. The dataset contains 23 columns as described below. The original dataset used abbreviations for all values. The dataset given has expanded the abbreviations. The description below is for the original dataset so it gives the abbreviations.
0. Classification: EDIBLE or POISONOUS<br>
1. cap-shape: bell=b,conical=c,convex=x,flat=f, knobbed=k,sunken=s<br>
2. cap-surface: fibrous=f,grooves=g,scaly=y,smooth=s<br>
3. cap-color: brown=n,buff=b,cinnamon=c,gray=g,green=r,pink=p,purple=u,red=e,white=w,yellow=y<br>
4. bruises?: bruises=t,no=f<br>
5. odor: almond=a,anise=l,creosote=c,fishy=y,foul=f, usty=m,none=n,pungent=p,spicy=s<br>
6. gill-attachment: attached=a,descending=d,free=f,notched=n<br>
7. gill-spacing: close=c,crowded=w,distant=d<br>
8. gill-size: broad=b,narrow=n<br>
9. gill-color: black=k,brown=n,buff=b,chocolate=h,gray=g, green=r,orange=o,pink=p,purple=u,red=e,white=w,yellow=y<br>
10. stalk-shape: enlarging=e,tapering=t<br>
11. stalk-root: bulbous=b,club=c,cup=u,equal=e,rhizomorphs=z,rooted=r,missing=?<br>
12. stalk-surface-above-ring: fibrous=f,scaly=y,silky=k,smooth=s<br>
13. stalk-surface-below-ring: fibrous=f,scaly=y,silky=k,smooth=s<br>
14. stalk-color-above-ring: brown=n,buff=b,cinnamon=c,gray=g,orange=o, pink=p,red=e,white=w,yellow=y<br>
15. stalk-color-below-ring: brown=n,buff=b,cinnamon=c,gray=g,orange=o, pink=p,red=e,white=w,yellow=y<br>
16. veil-type: partial=p,universal=u<br>
17. veil-color: brown=n,orange=o,white=w,yellow=y<br>
18. ring-number: none=n,one=o,two=t<br>
19. ring-type: cobwebby=c,evanescent=e,flaring=f,large=l,none=n,pendant=p,sheathing=s,zone=z<br>
20. spore-print-color: black=k,brown=n,buff=b,chocolate=h,green=r,orange=o,purple=u,white=w,yellow=y<br>
21. population: abundant=a,clustered=c,numerous=n,scattered=s,several=v,solitary=y<br>
22. habitat: grasses=g,leaves=l,meadows=m,paths=p, urban=u,waste=w,woods=d<br>
<br>
The goal is to create a model that predicts if a mushroom is edible or poisonous using Random Forests. The program print's out the model generated in a directory called mushroomModel. The program also print's out the confusion matrix in a directory called mushroomConfusion.<br>
Pprogram runs on AWS.<br>
Intellij is used to develop program. Program has build.sbt file that will generate the jar file that will run on AWS when sbt package is executed.
The build.sbt file is at the top level of the directory. Also at the top level in the directory a file called awscli.txt. This file contains the cli command that will run program on AWS.
