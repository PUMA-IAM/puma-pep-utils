#!/bin/bash

thrift --gen java pep.thrift
rm ../java/puma/peputils/gen-java -rf
cp gen-java/puma/ ../java/ -r
rm gen-java -rf
