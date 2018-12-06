# For testing:
#inherit kernel_wireless_regdb

# Hacky (and easy) way to use newer Linux kernel without touching
# Yocto machines and original Yocto kernel recipes.

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

SRCREV = "${AUTOREV}"
LINUX_VERSION = "4.20.0-rc5+git${SRCPV}"
PV = "${LINUX_VERSION}"

S = "${WORKDIR}/git"

SRCBRANCH = "master"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;name=machine;branch=${SRCBRANCH} \
    git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-4.15;destsuffix=${KMETA} \
"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRCREV_machine_qemuarm = "${SRCREV}"
SRCREV_machine_qemuarm64 = "${SRCREV}"
SRCREV_machine_qemumips = "${SRCREV}"
SRCREV_machine_qemuppc = "${SRCREV}"
SRCREV_machine_qemux86 = "${SRCREV}"
SRCREV_machine_qemux86-64 = "${SRCREV}"
SRCREV_machine_qemumips64 = "${SRCREV}"
SRCREV_machine = "${SRCREV}"

# Force revision for kernel-meta from v4.15 (cause version mismatch might
# cause using different kernel recipe, e.g. v4.12):
SRCREV_meta = "45c256a5ca6f9478bce212fec19e2bc273472631"

# Silence mismatch between SRCREV and LINUX_VERSION:
KERNEL_VERSION_SANITY_SKIP = "1"

# Bring localversion:
inherit kernel-localversion
SRC_URI += " \
    file://localversion.scc \
    file://localversion.cfg \
"

# Workaround for kernel.bbclass oldnoconfig:
# Since v4.19 "oldnoconfig" is gone. Before it was an alias to "olddefconfig" so fix it here.
# Copied from poky/meta/classes/kernel.bbclass.
KERNEL_CONFIG_COMMAND = "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"
