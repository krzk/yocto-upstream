# SPDX-License-Identifier: MIT
# Copyright (C) 2025 Krzysztof Kozlowski <krzk@kernel.org>

SUMMARY = "Network configuration for lab / board farm"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PV = "1.0"

SRC_URI = "\
    file://01-ether.network \
    "

S = "${WORKDIR}"

do_install () {
    install -Dm 0644 ${S}/01-ether.network ${D}${sysconfdir}/systemd/network/01-ether.network
}

FILES:${PN} = "\
    ${sysconfdir}/systemd/network/01-ether.network \
    "
