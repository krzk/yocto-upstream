# SPDX-License-Identifier: MIT
# Copyright (C) 2025 Krzysztof Kozlowski <krzk@kernel.org>

SUMMARY = "Packages with firmware for Qualcomm boards"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = "\
    firmware-qcom-sm8550-hdk \
    firmware-qcom-sm8650-hdk \
    linux-firmware-qca \
    linux-firmware-ath12k \
    "
