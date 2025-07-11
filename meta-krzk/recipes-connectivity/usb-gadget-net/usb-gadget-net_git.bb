# SPDX-License-Identifier: MIT
# Copyright (C) 2025 Krzysztof Kozlowski <krzk@kernel.org>

SUMMARY = "USB Gadget network for targets"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c1c00f9d3ed9e24fa69b932b7e7aff2"

SRC_URI = "git://github.com/krzk/tools.git;branch=master;protocol=https"

SRCREV = "3988b7949ce0c5233332b873dbc4a98668f448b7"
PV = "0.0-r1+git${SRCPV}"
# No real versions here, so silence:
# ERROR: krzk-tools-0.0+git-r0 do_packagedata: QA Issue: Package version for package krzk-tools-src went backwards which would break package feeds
ERROR_QA:remove = "version-going-backwards"

S = "${WORKDIR}/git"

inherit systemd

do_install () {
    install -dm 0755 ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/boards/common-usb-net/etc/systemd/system/usb-gadget-net.service ${D}${systemd_unitdir}/system

    # FIXME: Scripts have hard-coded /usr/bin path, need to fix it one day
    install -dm 0755 ${D}/usr/bin
    install -m 0755 ${S}/boards/common-usb-net/usr/bin/* ${D}/usr/bin/
}

FILES:${PN} = "\
    ${systemd_unitdir}/system/usb-gadget-net.service \
    /usr/bin/usb-gadget-cleanup \
    /usr/bin/usb-gadget-setup \
    "

SYSTEMD_SERVICE:${PN} = "usb-gadget-net.service"

