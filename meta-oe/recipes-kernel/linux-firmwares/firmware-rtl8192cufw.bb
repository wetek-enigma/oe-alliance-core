LICENSE = "CLOSED"
require conf/license/license-close.inc
PR = "r0"
SRC_URI = " \
    file://rtl8192cufw_TMSC.zip \
"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${base_libdir}/firmware"

PACKAGE_ARCH = "all"

SUMMARY = "Firmware for rtl8192cufw_TMSC"

do_install() {
    install -d ${D}${base_libdir}/firmware
    install -d ${D}${base_libdir}/firmware/rtlwifi
    install -m 0644 rtl8192cufw_TMSC.bin ${D}${base_libdir}/firmware/rtlwifi
}
