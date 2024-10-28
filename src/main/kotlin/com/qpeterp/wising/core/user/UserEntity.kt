package com.qpeterp.wising.core.user

import jakarta.persistence.*

@Entity
@Table(name = "tbl_user")
class UserEntity(
    id: Int = 0,
    username: String,
    password: String,
    role: UserRole = UserRole.USER,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = id
        private set

    @Column(nullable = false)
    var username = username
        private set

    @Column(nullable = false)
    var password = password
        private set

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var role = role
        private set
}