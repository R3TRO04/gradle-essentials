plugins {
    base
}



tasks.named<Wrapper>("wrapper") {
    gradleVersion = "8.14-rc-1"
    distributionType = Wrapper.DistributionType.ALL
}
