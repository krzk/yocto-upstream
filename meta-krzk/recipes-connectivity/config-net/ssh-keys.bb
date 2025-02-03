# SPDX-License-Identifier: MIT
# Copyright (C) 2025 Krzysztof Kozlowski <krzk@kernel.org>

SUMMARY = "SSH public keys"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PV = "1.0"

SRC_URI = "\
    file://authorized_keys \
    "

S = "${WORKDIR}"

USER_DIR = "root"

do_install() {
    install -m 0700 -d ${D}/${USER_DIR}/.ssh/
    install -m 0600 ${S}/authorized_keys ${D}/${USER_DIR}/.ssh/authorized_keys
}

FILES:${PN} = "/${USER_DIR}/.ssh/authorized_keys"
