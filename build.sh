#!/bin/bash/
javac -cp ".:bin/:/home/knifesurge/Documents/lwjgl-3.0.0/jar/lwjgl.jar:src.com.knifesurge.knife2dgame.entities:src.com.knifesurge.knife2dgame.game:src.com.knifesurge.knife2dgame.handlers:src.com.knifesurge.knife2dgame.pathfinding:src.com.knifesurge.knife2dgame.structures" src/com/knifesurge/knife2dgame/entities/*.java src/com/knifesurge/knife2dgame/game/*.java src/com/knifesurge/knife2dgame/handlers/*.java src/com/knifesurge/knife2dgame/pathfinding/*.java src/com/knifesurge/knife2dgame/structures/*.java -d bin
echo "Done"
