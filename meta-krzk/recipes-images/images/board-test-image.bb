# SPDX-License-Identifier: MIT
# Copyright (C) 2025 Krzysztof Kozlowski <krzk@kernel.org>

# See also:
# meta-openembedded/meta-initramfs/recipes-core/images/initramfs-debug-image.bb
# poky/meta/recipes-core/images/core-image-minimal-initramfs.bb
SUMMARY = "Small image capable of booting a device and testing it (for Samsung Exynos boards, see https://krzk.eu)"
LICENSE = "MIT"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-board-network \
    packagegroup-board-tests \
    ${ROOTFS_BOOTSTRAP_INSTALL} \
    "

# Disable installation of kernel and modules via packagegroup-core-boot
NO_RECOMMENDATIONS ?= "1"

# FIXME: decide about debug-tweaks
# empty-root-password+serial-autologin-root is needed for
# serial_autologin_root() rootfs postprocess command.  It still should not
# allow empty password root SSH login, though.
IMAGE_FEATURES = "ssh-server-dropbear allow-root-login empty-root-password serial-autologin-root"
IMAGE_FSTYPES = "${INITRAMFS_FSTYPES} cpio.xz cpio.gz.u-boot"

# From core-image-minimal-initramfs
# #################################
# Don't allow the initramfs to contain a kernel
PACKAGE_EXCLUDE = "kernel-image-*"

IMAGE_NAME_SUFFIX ?= ""
IMAGE_LINGUAS = ""

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE = "8192"
IMAGE_ROOTFS_EXTRA_SPACE = "0"
