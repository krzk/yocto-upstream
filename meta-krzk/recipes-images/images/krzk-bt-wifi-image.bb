SUMMARY = "Basic testing image: firmware"
LICENSE = "MIT"

inherit krzk-image

IMAGE_INSTALL += " \
    broadcom-bt-firmware \
    crda \
"