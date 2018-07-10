SUMMARY = "Basic testing image"
LICENSE = "MIT"

inherit krzk-image

IMAGE_INSTALL += " \
    libkcapi \
    openssl \
"
