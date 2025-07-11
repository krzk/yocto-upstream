# SPDX-License-Identifier: MIT
# Copyright (C) 2025 Krzysztof Kozlowski <krzk@kernel.org>

SUMMARY = "Packages for Qualcomm board testing"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = "\
    usb-gadget-net \
    v4l-utils \
    "
