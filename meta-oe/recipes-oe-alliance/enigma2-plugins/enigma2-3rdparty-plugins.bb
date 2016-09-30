SUMMARY = "3rd Party plugins for Enigma2"
MAINTAINER = "oe-alliance team"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=8e37f34d0e40d32ea2bc90ee812c9131"

inherit gitpkgv deploy

DEPENDS = "tslib mpfr gmp"

SRCREV = "${AUTOREV}"
PV = "3.2+gitr${SRCPV}"
PKGV = "3.2+gitr${GITPKGV}"
PR = "r108"

SRC_URI="git://github.com/oe-alliance/3rdparty-plugins.git;protocol=git"

EXTRA_OECONF = " \
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
"

ALLOW_EMPTY_${PN} = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/git"

THIRDPARTY_PLUGINS = " \
    enigma2-plugin-extensions-atmolightd_0.7-pre22_all.ipk \
    enigma2-plugin-extensions-bildonline_3.1rc6_mips32el.ipk \
    enigma2-plugin-extensions-bluray_1.5rc3_mips32el.ipk \
    enigma2-plugin-extensions-boblight-enigma2_0.8r8_mips32el.ipk \
    enigma2-plugin-extensions-camofs_9.19_all.ipk \
    enigma2-plugin-extensions-chefkoch_1.4rc9_all.ipk \
    enigma2-plugin-extensions-clevertanken_0.7rc1_all.ipk \
    enigma2-plugin-extensions-csfd_10-85-20150429_all.ipk \
    enigma2-plugin-extensions-cyrussettings_1.0.0_all.ipk \
    enigma2-plugin-extensions-digitalfernsehen_1.1rc10_all.ipk \
    enigma2-plugin-extensions-dvrproviderplayer_1.14_all.ipk \
    enigma2-plugin-extensions-ehue_0.2-r0_all.ipk \
    enigma2-plugin-extensions-enigmalight_0.2-rc1_all.ipk \
    enigma2-plugin-extensions-exodus_2.0_r1_all.ipk \
    enigma2-plugin-extensions-facebook_1.4_mips32el.ipk \
    enigma2-plugin-extensions-filesearchfs_2.53_all.ipk \
    enigma2-plugin-extensions-focusonline_1.0rc10_all.ipk \
    enigma2-plugin-extensions-fragmutti_0.5_all.ipk \
    enigma2-plugin-extensions-gmailreader-oe2.0_1.3_all.ipk \
    enigma2-plugin-extensions-googlenewsreader_1.0_mips32el.ipk \
    enigma2-plugin-extensions-hdmitest_0.4_mipsel.ipk \
    enigma2-plugin-extensions-hetweer_3.1_all.ipk \
    enigma2-plugin-extensions-iptvbouquet_1.0_r0_all.ipk \
    enigma2-plugin-extensions-isettinge2-3.3.8-oe2.0-${@base_contains("TARGET_ARCH", "sh4", "sh4" , "mips32el", d)}.ipk \
    enigma2-plugin-extensions-kicker_3.4rc9_all.ipk \
    enigma2-plugin-extensions-kino_1.6rc9_all.ipk \
    enigma2-plugin-extensions-kodidirect_3.0_r0_all.ipk \
    enigma2-plugin-extensions-livefootball_6.1_all.ipk \
    enigma2-plugin-extensions-mediainfo_3.0.0_all.ipk \
    enigma2-plugin-extensions-mediaportal-wallicons.ipk \
    enigma2-plugin-extensions-moviebrowser_3.6rc9_all.ipk \
    enigma2-plugin-extensions-mp3browser_1.9rc9_all.ipk \
    enigma2-plugin-extensions-netspeedtest_1.0_all.ipk \
    ${@base_contains('MACHINE_BRAND', 'Vu+', '' , 'enigma2-plugin-extensions-openopera_1.0-r0_mips32el.ipk', d)} \
    enigma2-plugin-extensions-opkg-tools_1.3_mipsel.ipk \
    enigma2-plugin-extensions-oscamstatusview_0.7rc1_mips32el.ipk \
    enigma2-plugin-extensions-piconmanager_2.2-20150329-r0_all.ipk \
    enigma2-plugin-extensions-piconsupdater_0.3.6_mips32el.ipk \
    enigma2-plugin-extensions-picturecenterfs_7.34_all.ipk \
    enigma2-plugin-extensions-planerfs_6.61_all.ipk \
    enigma2-plugin-extensions-pluginspanel_1.0_r01_all.ipk \
    enigma2-plugin-extensions-pluginupdater_0.1r2_all.ipk \
    enigma2-plugin-extensions-pravoslavietv_0.2_all.ipk \
    enigma2-plugin-extensions-pzyemail_0.8-20150614_all.ipk \
    enigma2-plugin-extensions-screengrabber_2.5_all.ipk \
    enigma2-plugin-extensions-screensaver_5.7.1_all.ipk \
    enigma2-plugin-extensions-sherlock_5.01r1_mipsel.ipk \
    enigma2-plugin-extensions-skyrecorder_1.6.1_all.ipk \
    enigma2-plugin-extensions-songs-to_0.1_mips32el.ipk \
    enigma2-plugin-extensions-spiegelonline_2.7rc1_all.ipk \
    enigma2-plugin-extensions-spinnerselector_2.1r5_mips32el.ipk \
    enigma2-plugin-extensions-sport1ticker_1.3_all.ipk \
    enigma2-plugin-extensions-sportportal_2013_all.ipk \
    enigma2-plugin-extensions-sundtekcontrolcenter_20160830-1_all.ipk \
    enigma2-plugin-extensions-tectimetv_3.1_all.ipk \
    enigma2-plugin-extensions-thetvdb_0.7-20120607-r2_mips32el.ipk \
    enigma2-plugin-extensions-tmbd_7.5_all.ipk \
    enigma2-plugin-extensions-translator_1.0rc1_all.ipk \
    enigma2-plugin-extensions-transmission_2.84_all.ipk \
    enigma2-plugin-extensions-tsmedia_11.2_all.ipk \
    enigma2-plugin-extensions-tstube_1.2_all.ipk \
    enigma2-plugin-extensions-tvspielfilm_6.4rc12_all.ipk \
    enigma2-plugin-extensions-verkehrsinfo_1.1rc1_mips32el.ipk \
    enigma2-plugin-extensions-vcs_2.1_all.ipk \
    enigma2-plugin-extensions-vhannibalautosettings_1.1_mips32el.ipk \
    enigma2-plugin-extensions-vuplusforum_0.8rc1_all.ipk \
    enigma2-plugin-extensions-webmedia_14.0_r0_all.ipk \
    enigma2-plugin-extensions-webradiofs_14.52_all.ipk \
    enigma2-plugin-extensions-weerinfo_2.3_all.ipk \
    enigma2-plugin-extensions-wikipedia_2.2rc10_all.ipk \
    enigma2-plugin-extensions-wwech_1.03_all.ipk \
    enigma2-plugin-extensions-xbmcaddons_8.1_r0_all.ipk \
    enigma2-plugin-extensions-xbmcwetter_1.3rc5_all.ipk \
    enigma2-plugin-extensions-zdfnewmediathek_1.7rc6_all.ipk \
    enigma2-plugin-feeds-picons.xyz_2015-08-31--19-55-30_all.ipk \
    enigma2-plugin-systemplugins-bouquetsprotection_0.2-rc1_all.ipk \
    enigma2-plugin-systemplugins-channelselectionnavigator_1.1_mipsel.ipk \
    enigma2-plugin-systemplugins-extnumberzap_1.17_all.ipk \
    enigma2-plugin-systemplugins-recinfobar_1.22rc2_mips32el.ipk \
    "

#     Install any packages t_append =hat are only For this machines feed here, uncomment the line below and change as required
THIRDPARTY_MACHINE_PLUGINS_vuuno = " \
    enigma2-plugin-extensions-sdg-imagedownloader-v0.7-oe-2.0-vu-all.ipk \
    "
THIRDPARTY_MACHINE_PLUGINS_vuultimo = " \
    enigma2-plugin-extensions-sdg-imagedownloader-v0.7-oe-2.0-vu-all.ipk \
    "
THIRDPARTY_MACHINE_PLUGINS_vusolo = " \
    enigma2-plugin-extensions-sdg-imagedownloader-v0.7-oe-2.0-vu-all.ipk \
    "
THIRDPARTY_MACHINE_PLUGINS_vuduo = " \
    enigma2-plugin-extensions-sdg-imagedownloader-v0.7-oe-2.0-vu-all.ipk \
    "
THIRDPARTY_MACHINE_PLUGINS_vusolo2 = " \
    enigma2-plugin-extensions-sdg-imagedownloader-v0.7-oe-2.0-vu-all.ipk \
    "
THIRDPARTY_MACHINE_PLUGINS_vuduo2 = " \
    enigma2-plugin-extensions-sdg-imagedownloader-v0.7-oe-2.0-vu-all.ipk \
    "
THIRDPARTY_MACHINE_PLUGINS_vusolose = " \
    enigma2-plugin-extensions-sdg-imagedownloader-v0.7-oe-2.0-vu-all.ipk \
    "
THIRDPARTY_MACHINE_PLUGINS_vuzero = " \
    enigma2-plugin-extensions-sdg-imagedownloader-v0.7-oe-2.0-vu-all.ipk \
    "
THIRDPARTY_MACHINE_PLUGINS_et6x00 = " \
    enigma2-plugin-extensions-et-webbrowser_2.0.0-r0_et6x00.ipk \
    "
THIRDPARTY_MACHINE_PLUGINS_et7x00 = " \
    enigma2-plugin-extensions-newxtrend-hbbtv_4.0-r0_et7x00.ipk \
    "
THIRDPARTY_MACHINE_PLUGINS_et8000 = " \
    enigma2-plugin-extensions-newxtrend-hbbtv_4.0-r0_et8000.ipk \
    enigma2-plugin-systemplugins-autorebootET8000_1.2_mipsel.ipk \
     "
THIRDPARTY_MACHINE_PLUGINS_et8500 = " \
    enigma2-plugin-extensions-newxtrend-hbbtv_4.0-r0_et8500.ipk \
    "
THIRDPARTY_MACHINE_PLUGINS_et9x00 = " \
    enigma2-plugin-extensions-et-webbrowser_2.0.0-r0_et9x00.ipk \
    "
THIRDPARTY_MACHINE_PLUGINS_et10000 = " \
    enigma2-plugin-extensions-newxtrend-hbbtv_4.0-r0_et10000.ipk \
     "
THIRDPARTY_MACHINE_PLUGINS_ultramini = " \
    ${@base_contains('MACHINEBUILD', 'et7x00mini', 'enigma2-plugin-extensions-hbbtv-et7x00mini_2.0-r0_et7x00mini.ipk' , '', d)} \
    ${@base_contains('MACHINEBUILD', 'xpeedlxcc', 'enigma2-plugin-extensions-hbbtv-xpeedc_2.0-r0_xpeedlxcc.ipk' , '', d)} \
    ${@base_contains('MACHINEBUILD', 'xpeedlxcs2', 'enigma2-plugin-extensions-hbbtv-xpeedlxcs2_2.0-r0_xpeedlxcs2.ipk' , '', d)} \
    "

THIRDPARTY_MACHINE_PLUGINS_g300 = " \
    ${@base_contains('MACHINEBUILD', 'sf3038', 'enigma2-plugin-extensions-hbbtv-octagon_1.0_mips32el.ipk' , '', d)} \
    ${@base_contains('MACHINEBUILD', 'mbtwinplus', 'enigma2-plugin-extensions-hbbtv-miracle_1.0_mips32el.ipk' , '', d)} \
    "

do_install[noexec] = "1"
do_package_write_ipk[noexec] = "1"

python populate_packages_prepend () {
    pkg  = ""
    pkgs = ""
    plugins = bb.data.getVar('THIRDPARTY_PLUGINS', d, 1)
    if bb.data.getVar('THIRDPARTY_MACHINE_PLUGINS', d, 1) is not None:
        plugins += bb.data.getVar('THIRDPARTY_MACHINE_PLUGINS', d, 1)
    if bb.data.getVar('THIRDPARTY_EXTRA_PLUGINS', d, 1) is not None:
        plugins += bb.data.getVar('THIRDPARTY_EXTRA_PLUGINS', d, 1)

    if plugins is not None:
        for package in plugins.split():
            pkg = package.split('_')[0]
            pkgs += pkg + " "
            bb.data.setVar('ALLOW_EMPTY_' + pkg, '1', d)

    bb.data.setVar('PACKAGES', pkgs, d)
}

do_deploy() {
    rm -rf ${DEPLOY_DIR_IPK}/3rdparty
    rm -rf ${DEPLOY_DIR_IPK}/${MACHINE}_3rdparty
    install -d 0755 ${DEPLOY_DIR_IPK}/3rdparty
    install -d 0755 ${DEPLOY_DIR_IPK}/${MACHINE}_3rdparty
    for i in ${THIRDPARTY_PLUGINS}; do
        if [ -f $i ]; then
            install -m 0644 $i ${DEPLOY_DIR_IPK}/3rdparty;
        fi
    done;
    for i in ${THIRDPARTY_MACHINE_PLUGINS}; do
        if [ -f $i ]; then
            install -m 0644 $i ${DEPLOY_DIR_IPK}/${MACHINE}_3rdparty;
        fi
    done;
    for i in ${THIRDPARTY_EXTRA_PLUGINS}; do
        if [ -f $i ]; then
            install -m 0644 $i ${DEPLOY_DIR_IPK}/3rdparty;
        fi
    done;
    pkgdir=${DEPLOY_DIR_IPK}/3rdparty
    if [ -e $pkgdir ]; then
        chmod 0755 $pkgdir
    fi
    pkgdir=${DEPLOY_DIR_IPK}/${MACHINE}_3rdparty
    if [ -e $pkgdir ]; then
        chmod 0755 $pkgdir
    fi
}

addtask do_deploy before do_package_write after do_package_write_ipk
