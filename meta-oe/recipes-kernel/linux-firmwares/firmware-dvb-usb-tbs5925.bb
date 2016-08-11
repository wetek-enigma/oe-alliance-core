DESCRIPTION = "Firmware for TBS 5925"
LICENSE = "CLOSED"

PR = "r1"
SRC_URI = "file://dvb-usb-tbsqbox-id5925.zip"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${base_libdir}/firmware"

PACKAGE_ARCH = "all"

do_install() {
    install -d ${D}${base_libdir}/firmware
    install -m 0644 dvb-usb-tbsqbox-id5925.fw ${D}${base_libdir}/firmware
}
