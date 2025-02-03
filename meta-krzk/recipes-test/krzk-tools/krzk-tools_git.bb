# SPDX-License-Identifier: MIT
# Copyright (C) 2025 Krzysztof Kozlowski <krzk@kernel.org>

SUMMARY = "krzk's various tools and tests"
HOMEPAGE = "https://krzk.eu"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c1c00f9d3ed9e24fa69b932b7e7aff2"

SRC_URI = "git://github.com/krzk/tools.git;branch=master;protocol=https"

SRCREV = "b02992d5a1c3fff47365ef9742d3a0be335492ea"
PV = "0.0+git${SRCPV}"

S = "${WORKDIR}/git"

RDEPENDS:${PN} = "\
    gzip \
    udev \
    usbutils \
"

do_install () {
    install -dm 0755 ${D}/opt/tools/tests/
    install -m 0644 ${S}/tests/* ${D}/opt/tools/tests/
}

FILES:${PN} = "\
    /opt/tools/tests/ \
    "
