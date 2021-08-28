#!/usr/bin/env bash

pid=`ps -ef | grep PYL-springboot-coupons.jar | grep -v grep | awk '{print $2}' `
if [[ -z "${pid}"]]
then
  echo application is already stoppped
else
  echo kill ${pid}
  kill  -9 ${pid}
fi