#!/bin/bash
{
echo Which Game would you like to run?
select gameName in RealGame PerfectGame WorstGame
do
mvn compile && mvn exec:java -Dexec.args="$gameName"
exit 1
done
}