DESCRIPTION = "serviceapp service for enigma2"
AUTHOR = "Maroš Ondrášek <mx3ldev@gmail.com>"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "enigma2 uchardet openssl"
RDEPENDS_${PN} = "enigma2 uchardet openssl"
RCONFLICTS_${PN} = "enigma2-plugin-extensions-serviceapp"
RREPLACES_${PN} = "enigma2-plugin-extensions-serviceapp"

#SRCREV = "${AUTOREV}"
SRCREV = "e28958c6e41db3d276adc649b4a8af4169bcfcae"
SRC_URI = "git://github.com/mx3L/serviceapp.git;branch=master"

S = "${WORKDIR}/git"

inherit autotools gitpkgv pythonnative pkgconfig

PV = "0.5+git${SRCPV}"
PKGV = "0.5+git${GITPKGV}"

PR = "r0"

EXTRA_OECONF = "\
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
	"

#do_install_append() {
#	rm ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/*.pyc
#}

FILES_${PN} = "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/*.pyo \
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/serviceapp.so"

FILES_${PN}-src = "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/*.py"

FILES_${PN}-dbg = "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/serviceapp.la"