SUMMARY = "Basic testing image: firmware"
LICENSE = "MIT"

inherit krzk-image

IMAGE_INSTALL += " \
    civetweb \
    python3-websockets \
"
