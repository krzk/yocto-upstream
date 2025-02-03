# SPDX-License-Identifier: MIT
# Copyright (C) 2025 Krzysztof Kozlowski <krzk@kernel.org>

SUMMARY = "Packages for networking setup for board testing"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = "\
    config-net \
    ssh-keys \
    "
