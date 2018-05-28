SUMMARY = "Basic testing image: firmware"
LICENSE = "MIT"

inherit krzk-image

IMAGE_INSTALL += " \
    civetweb \
    python3-websockets \
"

PACKAGECONFIG_append_pn-civetweb = " caching cgi cpp debug ipv6 server ssl websockets"
#PACKAGECONFIG_remove_pn-civetweb = " server websockets"
