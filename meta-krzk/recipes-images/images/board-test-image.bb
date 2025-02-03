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
IMAGE_FEATURES = "ssh-server-dropbear allow-root-login"
IMAGE_FSTYPES = "${INITRAMFS_FSTYPES} cpio.gz.u-boot"

# Enable local auto-login (on systemd) of the root user (local = serial port and
# virtual console by default, can be configured).
LOCAL_GETTY ?= "\
    ${IMAGE_ROOTFS}${systemd_system_unitdir}/serial-getty@.service \
    ${IMAGE_ROOTFS}${systemd_system_unitdir}/getty@.service \
    "
local_autologin () {
    sed -i -e 's/^\(ExecStart *=.*getty \)/\1--autologin root /' ${LOCAL_GETTY}
}
ROOTFS_POSTPROCESS_COMMAND += "${@oe.utils.conditional('VIRTUAL-RUNTIME_init_manager', 'systemd', 'local_autologin;', '', d)}"

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
