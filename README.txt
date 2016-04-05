{\rtf1\ansi\ansicpg1252\cocoartf1404\cocoasubrtf110
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
\paperw11900\paperh16840\margl1440\margr1440\vieww32600\viewh18840\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 G00301273 (John Conor Kenny) - A Heuristically Informed Fuzzy Maze Challenge\
Github URL: https://github.com/YesManKablam/2016AI\
\
Run the .jar in a folder with the resources folder and the fcl folder. You should just be able to double click on the .jar itself to run it. If not, navigate to it via terminal or command prompt and run it through that.\
\
Directional Arrows for movement.\
\
Z key controls zooming.\
\
There is a hidden escape ladder somewhere in the maze, and 6 zombies that will stumble around. \
\
If they catch you, the fuzzy logic will kick in and figure out if you\'92ll survive. If you do, the zombie will die. \
\
Pickup swords to increase your strength, and a higher strength means an easier job fighting zombies. \
\
Watch out though, every encounter will lower your total health, so avoid zombies if you can.\
\
Sprites are transparent, which caused a couple of odd things to happen. For instance, when zoomed out, Zombies look like walls. Also, if zoomed out and near the edges of the maze, the player node is replaced with a wall. If you zoom in, there\'92s no issues.\
\
When you pick up a weapon, it may seem like you\'92re stuck. You\'92re not, it\'92s just the game view being odd. Just try to move away from the node with the pickup and it goes back to normal. The player sprite is left behind on the node that previously contained a weapon, which was a way of tracking what pickups were collected.\
\
The Beam search is not implemented. Nodes are pulled up fine, and the Heuristic score is properly determined. However, I believe the ordering of the waiting list is what is causing things to not work. Code is still there, but nothing calls it.}