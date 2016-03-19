DESCRIPTION = "Amlogic Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

SRC_URI[md5sum] = "df6828070cef08319f5c5780bb1edc86"
SRC_URI[sha256sum] = "15d2a75ad9078b105ea506ec20e3a6a5fc83a41d7ba080f1486060be0f7cdcf9"

inherit kernel machine_kernel_pr

MACHINE_KERNEL_PR_append = ".1"
DEPENDS = "xz-native bc-native u-boot-mkimage-native gcc"

# Avoid issues with Amlogic kernel binary components
INSANE_SKIP_${PN} += "already-stripped"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_STRIP = "1"
LINUX_VERSION ?= "3.10.93"
LINUX_VERSION_EXTENSION ?= "amlogic"

COMPATIBLE_MACHINE = "(wetekplay)"

# WARNING reverted to version 93 in the 94 patch to make modules work
#SRC_URI = "file://master.tar.gz 
SRC_URI = "http://github.com/wetek-enigma/linux-wetek-3.10.y/archive/master.tar.gz \
    file://defconfig \
    file://tsync_pcr.c \
    file://aml_pmu4_codec.c \
    file://video.c \
    file://vpp.c \
    file://ftrace.h \
    file://return_address.c \
    file://hdmi_tx_cec.h \
    file://hdmi_tx_cec.c \
    file://MakefileArchArm \
"
#    file://patch-3.10.93-94.patch


S = "${WORKDIR}/linux-wetek-3.10.y-master"
B = "${WORKDIR}/build"

do_configure_prepend () {
    cd ${STAGING_KERNEL_DIR}
   find -type f -name "*.z" -print0 | xargs -0 cp -f --parents -t ${B}

# try with original dB values
    cp -f ${WORKDIR}/aml_pmu4_codec.c ${WORKDIR}/linux-wetek-3.10.y-master/sound/soc/codecs/
# Already in new kernel
#    cp -f ${WORKDIR}/vmpeg12_mc.c ${WORKDIR}/linux-wetek-3.10.y-master/drivers/amlogic/amports/m6/ucode/mpeg12/
#    cp -f ${WORKDIR}/ptsserv.c ${WORKDIR}/linux-wetek-3.10.y-master/drivers/amlogic/amports/
#    cp -f ${WORKDIR}/vh264.c ${WORKDIR}/linux-wetek-3.10.y-master/drivers/amlogic/amports/

# video.c same except:
#EXPORT_SYMBOL(video_property_changed); EXPORT_SYMBOL(amvideo_get_scaler_para);EXPORT_SYMBOL(amvideo_set_scaler_para);
#EXPORT_SYMBOL(amvideo_get_scaler_mode);
    cp -f ${WORKDIR}/video.c ${WORKDIR}/linux-wetek-3.10.y-master/drivers/amlogic/amports/

# video.c same except:
#EXPORT_SYMBOL(vpp_set_video_source_crop);EXPORT_SYMBOL(vpp_get_video_source_crop);
#EXPORT_SYMBOL(vpp_set_video_layer_position);EXPORT_SYMBOL(vpp_get_video_layer_position);
#EXPORT_SYMBOL(vpp_set_global_offset);EXPORT_SYMBOL(vpp_get_global_offset);
    cp -f ${WORKDIR}/vpp.c ${WORKDIR}/linux-wetek-3.10.y-master/drivers/amlogic/amports/

# tsync_pcr.c our is very different!
#    cp -f ${WORKDIR}/tsync_pcr.c ${WORKDIR}/linux-wetek-3.10.y-master/drivers/amlogic/amports/

# gcc 5.3 fix
    cp -f ${WORKDIR}/ftrace.h ${WORKDIR}/linux-wetek-3.10.y-master/arch/arm/include/asm/
    cp -f ${WORKDIR}/return_address.c ${WORKDIR}/linux-wetek-3.10.y-master/arch/arm/kernel/


}

do_compile_prepend () {
    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS MACHINE
    if test -n "${KERNEL_DEVICETREE}"; then
        for DTB in ${KERNEL_DEVICETREE}; do
            if echo ${DTB} | grep -q '/dts/'; then
                bbwarn "${DTB} contains the full path to the the dts file, but only the dtb name should be used."
                DTB=`basename ${DTB} | sed 's,\.dts$,.dtb,g'`
            fi
            oe_runmake ${DTB} CC="${KERNEL_CC}" LD="${KERNEL_LD}" ${KERNEL_EXTRA_ARGS}
        done
    # Create directory, this is needed for out of tree builds
    mkdir -p ${B}/arch/arm/boot/dts/amlogic/
    fi
}

# Put debugging files into dbg package
FILES_kernel-dbg += "/usr/src/kernel/drivers/amlogic/input/touchscreen/gslx680/.debug"


do_install_append () {
    ln -s ${STAGING_KERNEL_DIR}/arch/arm/mach-meson6 ${STAGING_KERNEL_DIR}/include/mach
    touch ${STAGING_KERNEL_DIR}/include/linux/smp_lock.h
    # remove *.z from installation path those are object files from amlogic for binary modules
    find ${D}/usr/src/kernel -type f -name "*.z" | xargs rm -f
}

do_rm_work() {
}
