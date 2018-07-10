SUMMARY = "Basic testing image"
LICENSE = "MIT"

inherit krzk-image

IMAGE_INSTALL += " \
    python-grpcio-tools \
    python-daemon \
    python-pybluez \
    udevil \
"
