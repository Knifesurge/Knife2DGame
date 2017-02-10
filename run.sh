#!/bin/bash/
java -cp ".:bin/:/home/knifesurge/Documents/lwjgl-3.0.0/jar/lwjgl.jar:src.com.knifesurge.knife2dgame.entities:src.com.knifesurge.knife2dgame.game:src.com.knifesurge.knife2dgame.handlers:src.com.knifesurge.knife2dgame.pathfinding:src.com.knifesurge.knife2dgame.structures" -Djava.library.path="lwjgl-3.0.0/native" com.knifesurge.knife2dgame.game.Game
