#!/bin/sh

let PORT_START=20000
declare -a USED_PORTS

function getFreePort() {
  let "PORT=$RANDOM+$PORT_START"
  while [ "x" == "x" ]; do
    PORT_USED="false"
    for (( i=1; i <= ${#USED_PORTS[@]}; i++ )); do
      if [ "x${PORT}" == "x${USED_PORTS[$i]}" ]; then
        PORT_USED="true"
      fi
    done
    if [ "${PORT_USED}" == "true" ]; then
      let "PORT=$RANDOM+$PORT_START"
    elif [ "x`nmap localhost -p${PORT} | grep ${PORT} | grep closed`" != "x" ]; then
      echo $PORT
      return
    else
      let "PORT=$RANDOM+$PORT_START"
    fi
  done
}

USED_PORTS[1]=`getFreePort`
USED_PORTS[2]=`getFreePort`
USED_PORTS[3]=`getFreePort`
echo ${USED_PORTS[1]}
echo ${USED_PORTS[2]}
echo ${USED_PORTS[3]}
