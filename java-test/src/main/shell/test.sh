#!/bin/sh
#如何统计文件第一列内容相同的行总有多少条呢
echo "Method one:"
awk '{print $1}' $1|sort|uniq -c|sort -g|awk '{print $2, $1}'
echo "Method two:"
awk '{count[$1]++}END{for(i in count)print i,count[i]}' $1|sort -t" " -k2n
