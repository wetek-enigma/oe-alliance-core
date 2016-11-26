LICENSE = "CLOSED"
require conf/license/license-close.inc
PR = "r0"
SRC_URI = " \
    file://rtl8192eu_nic.zip \
"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${base_libdir}/firmware"

PACKAGE_ARCH = "all"

SUMMARY = "Firmware for rtl8192eu"

do_install() {
    install -d ${D}${base_libdir}/firmware
    install -d ${D}${base_libdir}/firmware/rtlwifi
    install -m 0644 rtl8192eu_nic.bin ${D}${base_libdir}/firmware/rtlwifi
}
