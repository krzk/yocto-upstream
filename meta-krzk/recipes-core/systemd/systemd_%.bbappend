FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "\
    file://90-sysctl-debug.conf \
    "

do_install:append() {
    install -d ${D}${sysconfdir}/sysctl.d/
    install -m 0644 ${WORKDIR}/90-sysctl-debug.conf ${D}${sysconfdir}/sysctl.d/
}
