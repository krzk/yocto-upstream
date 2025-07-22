# Enable rtcwake
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "\
    file://fdisk_gpt.cfg \
    file://rtcwake.cfg \
    file://xargs.cfg \
    "
