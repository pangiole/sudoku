#!/usr/bin/env bash

readonly self_dir="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
java -jar "$self_dir/target/sudoku-1.0-SNAPSHOT-jar-with-dependencies.jar" $1