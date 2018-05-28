SUMMARY = "Base for krzk's images"
LICENSE = "MIT"

# From core-image-minimal
IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"
IMAGE_LINGUAS = " "
inherit core-image
MAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"

# Addons
IMAGE_FEATURES += "ssh-server-dropbear"
