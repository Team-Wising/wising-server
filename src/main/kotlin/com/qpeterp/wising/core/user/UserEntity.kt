package com.qpeterp.wising.core.user

import jakarta.persistence.*

@Entity
@Table(name = "tbl_user")
class UserEntity(
    id: Long = 0,
    email: String,
    password: String,
    role: UserRole = UserRole.USER,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = id
        private set

    @Column(nullable = false)
    var email = email
        private set

    @Column(nullable = false)
    var password = password
        private set

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var role = role
        private set
}