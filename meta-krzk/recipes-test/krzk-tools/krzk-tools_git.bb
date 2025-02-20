# SPDX-License-Identifier: MIT
# Copyright (C) 2025 Krzysztof Kozlowski <krzk@kernel.org>

SUMMARY = "krzk's various tools and tests"
HOMEPAGE = "https://krzk.eu"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c1c00f9d3ed9e24fa69b932b7e7aff2"

SRC_URI = "git://github.com/krzk/tools.git;branch=master;protocol=https"

SRCREV = "b5be3988c65e6ad19fd00c9469d57e2e1a524339"
PV = "0.0+git${SRCPV}"
# No real versions here, so silence:
# ERROR: krzk-tools-0.0+git-r0 do_packagedata: QA Issue: Package version for package krzk-tools-src went backwards which would break package feeds
ERROR_QA:remove = "version-going-backwards"

S = "${WORKDIR}/git"

# util-linux-rtcwake or CONFIG_RTCWAKE enabled in busybox
RDEPENDS:${PN} = "\
    bash \
    gzip \
    udev \
    usbutils \
"

do_install () {
    install -dm 0755 ${D}/opt/tools/tests/
    install -m 0755 ${S}/tests/* ${D}/opt/tools/tests/
}

FILES:${PN} = "\
    /opt/tools/tests/ \
    "
