SUMMARY = "Basic testing image"
LICENSE = "MIT"

inherit krzk-image

IMAGE_INSTALL += " \
    civetweb \
    python3-websockets \
"
