SUMMARY = "USB DVB driver for AS102 chipset"
PACKAGE_ARCH = "all"

require conf/license/license-gplv2.inc

DVBPROVIDER ?= "kernel"

RRECOMMENDS_${PN} = " \
    ${DVBPROVIDER}-module-dvb-as102 \
    ${DVBPROVIDER}-module-as102-fe \
    firmware-as102-data1-st \
    firmware-as102-data2-st \
    "

PV = "1.0"
PR = "r3"

ALLOW_EMPTY_${PN} = "1"
