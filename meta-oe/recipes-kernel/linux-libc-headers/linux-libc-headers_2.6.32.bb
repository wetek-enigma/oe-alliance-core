require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

SRC_URI[md5sum] = "f9c782399f1609c67bb78405a8d6e021"
SRC_URI[sha256sum] = "723106c298c5ba8733bb51ecc106b05e332a18490edc5f61cc6e57dbb36dcc46"

SRC_URI += "file://linuxdvb.patch \
    file://ppp.patch \
    file://types.patch \
"

# sh4 boxes require some headers from the kernel modules (for the framebuffer and ioctls) which are not shipped by the kernel headers. In order to avoid adding explicit sh4-conditional dependancies to the driver package in several packages (just for a couple of generic headers) we add them here. In this way, we also avoid unnecessary rebuilds of several stuff when drivers are updated.

SRC_URI_append_sh4 = "\
    file://stmfb.h \
    file://stm_ioctls.h \
"

do_install_append_sh4() {
    install -d ${D}/${includedir}/linux/dvb
    install -m 644 ${WORKDIR}/stm_ioctls.h ${D}/${includedir}/linux/dvb
    install -m 644 ${WORKDIR}/stmfb.h ${D}/${includedir}/linux
}

