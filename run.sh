#!/bin/sh

cd bataille;
mvn compile
mvn exec:java -Dexec.mainClass="upmc.game.Bataille"
cd ..
